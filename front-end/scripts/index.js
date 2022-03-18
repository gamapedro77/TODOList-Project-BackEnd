const tarefas = [];

function onClickNovaTarefa() {
  const main = document.getElementById("main");
  main.classList.toggle("active");

  const popup = document.getElementById("form-container-popup");
  popup.classList.toggle("active");
}

function onClickCriarTarefa() {
  const nomeTarefa = document.getElementById("nome-tarefa").value;
  const categoriaTarefa = document.getElementById("categoria-tarefa").value;
  const descricaoTarefa = document.getElementById("descricao-tarefa").value;
  const dataTarefa = document.getElementById("data-tarefa").value;
  const prioridadeTarefa = document.getElementById("prioridade-tarefa").value;

  tarefas.push({
    nome: nomeTarefa,
    categoria: categoriaTarefa,
    descricao: descricaoTarefa,
    data: dataTarefa,
    prioridade: prioridadeTarefa,
  });

  console.log(tarefas);

  const listItem = document.createElement("li");
  listItem.setAttribute("id", tarefas.length - 1);
  listItem.classList.add("tarefa");

  const containerNome = document.createElement("div");

  const h3 = document.createElement("h3");
  h3.innerText = nomeTarefa;

  const details = document.createElement("details");
  const summary = document.createElement("summary");
  summary.innerText = "Descrição";
  const text = document.createElement("p");
  text.innerText = descricaoTarefa;

  details.appendChild(summary);
  details.appendChild(text);

  containerNome.appendChild(h3);
  containerNome.appendChild(details);

  listItem.appendChild(containerNome);

  const containerBotoes = document.createElement("div");
  const buttonDeletar = document.createElement("button");
  buttonDeletar.innerText = "Deletar";
  buttonDeletar.setAttribute("onClick", "onClickDeletarTarefa()");
  containerBotoes.appendChild(buttonDeletar);
  const buttonEditar = document.createElement("button");
  buttonEditar.innerText = "Editar";
  containerBotoes.appendChild(buttonEditar);

  listItem.appendChild(containerBotoes);

  const containerData = document.createElement("div");
  const data = dataTarefa.split("-");

  const dia = document.createElement("h3");
  dia.innerText = data[2];

  const mes = document.createElement("h3");
  mes.innerText = data[1];

  containerData.appendChild(dia);
  containerData.appendChild(mes);

  listItem.appendChild(containerData);

  const list = document.getElementsByClassName("lista-tarefas");
  list[0].appendChild(listItem);

  const main = document.getElementById("main");
  main.classList.toggle("active");

  const popup = document.getElementById("form-container-popup");
  popup.classList.toggle("active");
}