document.addEventListener("DOMContentLoaded", function () {
    const btnAlterar = document.getElementById("btnAlterar");
    btnAlterar.addEventListener("click", () => {
        document.getElementById("paragrafo").textContent = "Texto alterado!";
    });

    const btnMap = document.getElementById("btnMap");
    btnMap.addEventListener("click", () => {
        const numeros = [1, 2, 3, 4, 5];
        const resultado = numeros.map((num) => num * 2);
        document.getElementById("resultadoMap").textContent =
            "Resultado: " + resultado.join(", ");
    });

    const btnFilter = document.getElementById("btnFilter");
    btnFilter.addEventListener("click", () => {
        const numeros = [5, 12, 8, 20, 3, 15];
        const resultado = numeros.filter((num) => num > 10);
        document.getElementById("resultadoFilter").textContent =
            "Resultado: " + resultado.join(", ");
    });

    const btnReduce = document.getElementById("btnReduce");
    btnReduce.addEventListener("click", () => {
        const numeros = [10, 20, 30, 40];
        const resultado = numeros.reduce((ac, num) => ac + num, 0);
        document.getElementById("resultadoReduce").textContent =
            "Soma total: " + resultado;
    });

    const btnFind = document.getElementById("btnFind");
    btnFind.addEventListener("click", () => {
        const produtos = [
            { nome: "Produto A", preco: 30 },
            { nome: "Produto B", preco: 55 },
            { nome: "Produto C", preco: 70 },
        ];
        const produto = produtos.find((prod) => prod.preco > 50);
        document.getElementById("resultadoFind").textContent =
            "Produto encontrado: " +
            (produto
                ? produto.nome + " - R$ " + produto.preco
                : "Nenhum produto encontrado");
    });

    const btnForEach = document.getElementById("btnForEach");
    btnForEach.addEventListener("click", () => {
        const frutas = ["maçã", "banana", "laranja"];
        let resultado = "";
        frutas.forEach((fruta) => (resultado += fruta + ", "));
        resultado = resultado.slice(0, -2);
        document.getElementById("resultadoForEach").textContent =
            "Frutas: " + resultado;
    });

    const btnFetch = document.getElementById("btnFetch");
    btnFetch.addEventListener("click", async () => {
        try {
            const response = await fetch(
                "https://jsonplaceholder.typicode.com/users/2"
            );
            const usuario = await response.json();
            document.getElementById("resultadoFetch").textContent =
                "Usuário: " + usuario.name;
        } catch (error) {
            document.getElementById("resultadoFetch").textContent =
                "Erro ao buscar usuário.";
        }
    });

    const btnEnviar18 = document.querySelector("#btnEnviar18");
    btnEnviar18.addEventListener("click", () => {
        const nome = document.querySelector("#inputNome18").value;
        const idade = document.querySelector("#inputIdade18").value;

        localStorage.setItem(
            "user",
            JSON.stringify({ nome: nome, idade: idade })
        );
    });

    const btnLocalStorage = document.getElementById("btnLocalStorage");
    btnLocalStorage.addEventListener("click", () => {
        const user = JSON.parse(localStorage.getItem("user"));
        document.getElementById("resultadoLocalStorage").textContent =
            "Usuario: " + JSON.stringify(user);
    });

    const formulario = document.getElementById("formulario");
    formulario.addEventListener("submit", (e) => {
        e.preventDefault();
        const nome = document.getElementById("inputNome").value.trim();
        if (nome === "") {
            alert("Por favor, preencha o campo de nome.");
        } else {
            alert("Olá, " + nome + "!");
        }
    });

    const atualizarRelogio = () => {
        const agora = new Date();
        const horas = String(agora.getHours()).padStart(2, "0");
        const minutos = String(agora.getMinutes()).padStart(2, "0");
        const segundos = String(agora.getSeconds()).padStart(2, "0");
        document.getElementById(
            "relogioDigital"
        ).textContent = `${horas}:${minutos}:${segundos}`;
    };
    setInterval(atualizarRelogio, 1000);
    atualizarRelogio();
});
