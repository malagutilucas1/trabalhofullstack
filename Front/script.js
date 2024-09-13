document.querySelector('#formPessoa').addEventListener('submit', async (e) => {
    e.preventDefault();

    const dadosPessoa = {
        nome: document.querySelector('#nome').value,
        cpf: document.querySelector('#cpf').value,
        telefone: document.querySelector('#telefone').value
    };

    try {
        const resposta = await fetch('http://localhost:3000/api/pessoas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dadosPessoa)
        });

        const resultado = await resposta.json();

        const mensagem = document.querySelector('#message');
        if (resposta.ok) {
            mensagem.textContent = 'Cadastro realizado com sucesso!';
            document.querySelector('#formPessoa').reset();
        } else {
            mensagem.textContent = `Erro no cadastro: ${resultado.message}`;
        }
    } catch (erro) {
        document.querySelector('#message').textContent = 'Falha ao se conectar com o servidor.';
    }
});
