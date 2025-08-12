document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("loginForm");

    if (!form) {
        console.error("Formulaire de connexion introuvable !");
        return;
    }

    form.addEventListener("submit", async (e) => {
        e.preventDefault(); // Empêche le rechargement de la page

        const flotteurNum = document.getElementById("userNum").value.trim();

        if (!flotteurNum) {
            alert("Veuillez entrer un numéro.");
            return;
        }

        try {
            const response = await fetch(`https://3801f0d4b2e7.ngrok-free.app/user/exists/${flotteurNum}`, {
                headers: {
                    "ngrok-skip-browser-warning": "true"
                }
            });

            if (!response.ok) {
                throw new Error(`Erreur serveur : ${response.status}`);
            }

            const exists = await response.json();

            if (exists === true) {
                // Numéro trouvé → on le stocke et on redirige
                localStorage.setItem("flotteurNum", flotteurNum);
                console.log(`Numéro ${flotteurNum} trouvé. Redirection vers lignes.html...`);
                window.location.href = "lignes.html";
            } else {
                alert("Ce numéro n'existe pas. Veuillez vérifier.");
            }
        } catch (error) {
            console.error("Erreur de connexion :", error);
            alert("Impossible de vérifier le numéro. Serveur injoignable.");
        }
    });
});
