document.addEventListener('DOMContentLoaded', () => {
    const flotteurNum = localStorage.getItem("flotteurNum");

    if (!flotteurNum) {
        alert("Aucun flotteur connecté. Redirection vers la page de connexion...");
        window.location.href = "index.html";
        return;
    }

    fetchLignes();

    setInterval(() => {
        const searchInput = document.getElementById('searchInput');
        if (searchInput && searchInput.value.trim() === '') {
            fetchLignes();
        }
    }, 5000);

    document.getElementById('searchInput').addEventListener('input', (e) => {
        filterTable(e.target.value);
    });

    document.getElementById("facturesBtn").addEventListener("click", () => {
        window.location.href = "facture.html";
    });
});

async function fetchLignes() {
    try {
        const response = await fetch('https://3801f0d4b2e7.ngrok-free.app/api/lignes/all', {
            headers: { 'ngrok-skip-browser-warning': 'true' }
        });

        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);

        const lignes = await response.json();
        displayLignes(lignes);
    } catch (error) {
        console.error('Erreur lors du chargement des lignes:', error);
    }
}

function displayLignes(lignes) {
    const tbody = document.querySelector("table tbody");
    tbody.innerHTML = "";

    lignes.forEach(ligne => {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${ligne.employe.nom_employe} ${ligne.employe.prenom_employe}</td>
            <td>${ligne.num}</td>
            <td>${ligne.type}</td>
            <td>${ligne.statut}</td>
            <td>${ligne.appelsMinutes} min / ${ligne.nombreSMS} SMS / ${ligne.dataGo} Go</td>
            <td><button class="charger-btn">Charger</button></td>
        `;

        row.querySelector(".charger-btn").addEventListener("click", () => {
            ouvrirPopupCharge(ligne.num);
        });

        tbody.appendChild(row);
    });
}

function filterTable(keyword) {
    const rows = document.querySelectorAll("table tbody tr");
    keyword = keyword.toLowerCase();

    rows.forEach(row => {
        row.style.display = row.textContent.toLowerCase().includes(keyword) ? "" : "none";
    });
}

function remplirSelect(selectId, max, step = 1) {
    const select = document.getElementById(selectId);
    select.innerHTML = "";
    for (let i = 0; i <= max; i += step) {
        const option = document.createElement("option");
        option.value = i;
        option.textContent = `${i}`;
        select.appendChild(option);
    }
}

function ouvrirPopupCharge(numLigne) {
    document.getElementById("ligneSelectionnee").textContent = `Ligne : ${numLigne}`;
    document.getElementById("popupCharge").classList.remove("hidden");

    remplirSelect("minutesSelect", 300, 10); // minutes
    remplirSelect("smsSelect", 500, 10); // SMS
    remplirSelect("goSelect", 50, 1); // Go

    document.getElementById("validerCharge").onclick = () => {
        const appelsMinutes = parseInt(document.getElementById("minutesSelect").value) || 0;
        const nombreSMS = parseInt(document.getElementById("smsSelect").value) || 0;
        const dataGo = parseFloat(document.getElementById("goSelect").value) || 0;

        if (appelsMinutes === 0 && nombreSMS === 0 && dataGo === 0) {
            alert("Veuillez saisir au moins une valeur à charger.");
            return;
        }

        chargerLigne(numLigne, appelsMinutes, nombreSMS, dataGo);
    };

    document.getElementById("annulerCharge").onclick = () => {
        document.getElementById("popupCharge").classList.add("hidden");
    };
}

async function chargerLigne(numLigne, appelsMinutes, nombreSMS, dataGo) {
    try {
        const response = await fetch(`https://3801f0d4b2e7.ngrok-free.app/api/lignes/charger/${numLigne}`, {
            method: "POST",
            headers: { 
                "Content-Type": "application/json",
                "ngrok-skip-browser-warning": "true"
            },
            body: JSON.stringify({ appelsMinutes, nombreSMS, dataGo })
        });

        if (!response.ok) throw new Error(`Erreur HTTP : ${response.status}`);

        alert(`Ligne ${numLigne} rechargée avec succès !`);
        document.getElementById("popupCharge").classList.add("hidden");
        fetchLignes();
    } catch (error) {
        console.error("Erreur recharge :", error);
        alert("Échec de la recharge.");
    }
}
