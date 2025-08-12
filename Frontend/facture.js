document.addEventListener('DOMContentLoaded', () => {
    const flotteurNum = localStorage.getItem("flotteurNum");

    if (!flotteurNum) {
        alert("Aucun flotteur connecté. Redirection vers la page de connexion...");
        window.location.href = "index.html";
        return;
    }

    fetchFactures();

    // Recharger automatiquement sauf si recherche active
    const autoRefresh = setInterval(() => {
        const searchInput = document.getElementById('searchInput');
        if (searchInput.value.trim() === '') {
            fetchFactures();
        }
    }, 5000);

    // Barre de recherche
    const searchInput = document.getElementById('searchInput');
    searchInput.addEventListener('input', (e) => {
        filterTable(e.target.value);
    });
});

async function fetchFactures() {
    try {
        const response = await fetch('https://3801f0d4b2e7.ngrok-free.app/facture/all', {
            headers: {
                'ngrok-skip-browser-warning': 'true'
            }
        });

        if (!response.ok) throw new Error(`Erreur HTTP: ${response.status}`);

        const factures = await response.json();
        displayFactures(factures);
        console.log('Factures chargées avec succès:', factures);
    } catch (error) {
        console.error('Erreur lors du chargement des factures:', error);
    }
}

function displayFactures(factures) {
    const tbody = document.querySelector("table tbody");
    tbody.innerHTML = "";

    factures.forEach(facture => {
        const numero =  facture.id_facture;
        const montant = facture.montant;
        const etat = facture.etat;
        const dateFormatted = new Date(facture.datePaiement).toLocaleString('fr-FR');
        const nomEmploye = facture.ligne.employe ? facture.ligne.employe.nom_employe : '';
        const prenomEmploye = facture.ligne.employe ? facture.ligne.employe.prenom_employe : '';

        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${numero}</td>
            <td>${montant} TND</td>
            <td><span class="etat ${etat.toUpperCase() === 'PAYE' ? 'paye' : 'impaye'}">${etat}</span></td>
            <td>${dateFormatted}</td>
            <td>${nomEmploye} ${prenomEmploye}</td>

        `;
        tbody.appendChild(row);
    });
}

function filterTable(keyword) {
    const rows = document.querySelectorAll("table tbody tr");
    const search = keyword.toLowerCase();

    rows.forEach(row => {
        const text = row.textContent.toLowerCase();
        row.style.display = text.includes(search) ? "" : "none";
    });
}
