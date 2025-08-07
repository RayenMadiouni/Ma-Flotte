document.addEventListener('DOMContentLoaded', () => {
    fetchLignes();

    // Recharger automatiquement sauf si recherche active
    let autoRefresh = setInterval(() => {
        const searchInput = document.getElementById('searchInput');
        if (searchInput.value.trim() === '') {
            fetchLignes();
        }
    }, 5000);

    // Barre de recherche
    const searchInput = document.getElementById('searchInput');
    searchInput.addEventListener('input', (e) => {
        filterTable(e.target.value);
    });
});

async function fetchLignes() {
    try {
        const response = await fetch('https://273668e3a60f.ngrok-free.app/api/lignes/all', {
            headers: {
                'ngrok-skip-browser-warning': 'true'
            }
        });
        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
        const lignes = await response.json();
        displayLignes(lignes);
        console.log('Lignes chargées avec succès:', lignes);
    } catch (error) {
        console.error('Erreur lors du chargement des lignes:', error);
    }
}

function displayLignes(lignes) {
    const tbody = document.querySelector('tbody');
    tbody.innerHTML = ''; // Vider le tableau

    lignes.forEach(ligne => {
        const nomEmploye = ligne.employe ? ligne.employe.nom_employe : '';
        const prenomEmploye = ligne.employe ? ligne.employe.prenom_employe : '';

        row = document.createElement('tr');
        row.innerHTML = `
            <td>${nomEmploye} ${prenomEmploye}</td>
            <td>${ligne.num}</td>
            <td>${ligne.type}</td>
            <td><span class="statut ${ligne.statut.toUpperCase() === 'ACTIVÉ' ? 'actif' : 'inactif'}">${ligne.statut}</span></td>
            <td>${ligne.appelsMinutes} min , ${ligne.nombreSMS} SMS , ${ligne.dataGo} Go</td>
        `;
        tbody.appendChild(row);
    });
}

function filterTable(searchTerm) {
    const rows = document.querySelectorAll('tbody tr');
    rows.forEach(row => {
        const text = row.textContent.toLowerCase();
        row.style.display = text.includes(searchTerm.toLowerCase()) ? '' : 'none';
    });
}
