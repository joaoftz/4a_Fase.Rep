import React, { useState } from 'react';

function Card({ tarefa, buscarTarefas }) {
  const [atribuirTarefa, setAtribuirTarefa] = useState({
    id_usuario: '',
    data_aluguel: ''
  });

  const alterarStatus = async (novoStatus) => {
    if (novoStatus === 'fazendo') {
      setIsAtribuirTarefaModalOpen(true);
    } else {
      await atualizarTarefa(novoStatus);
    }
  };
  const atualizarTarefa = async (novoStatus, dadosTarefa = null) => {
    const body = { ...tarefa, status: novoStatus };
    if (dadosTarefa) {
      body.id_usuario = dadosTarefa.id_usuario;
      body.data_cadastro = dadosTarefa.data_cadastro;
    }
    await fetch(`http://localhost:3000/tarefas/${tarefa.id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(body)
    });
    buscarTarefas();
  };

  const salvarTarefas = async () => {
    await atualizarTarefa('fazendo', atribuirTarefa);
    setIsAtribuirTarefaModalOpen(false);
    setAtribuirTarefaData({ id_usuario: '', data_cadastro: '' });
  };


  const editarTarefa = async () => {
    await fetch(`http://localhost:3000/tarefas/${tarefa.id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(editedTar)
    });
    buscarTarefas();
    setIsEditModalOpen(false);
  };

  const deletarTarefa = async () => {
    const confirmed = window.confirm("Tem certeza de que deseja deletar esta Tarefa?");
    if (confirmed) {
      await fetch(`http://localhost:3000/tarefas/${tarefa.id}`, { method: 'DELETE' });
      buscarTarefas();
    }
  };

  return (
    <div className="card">
      <h3>{tarefa.descricao_tarefa}</h3>
      <p>NomeSetor: {tarefa.nome_setor}</p>
      <p>Prioridade: {tarefa.prioridade}</p>
      {/* <p>Situação: {carro.status}</p> */}
      
      {tarefa.status === 'disponivel' && (
        <>
          <button onClick={() => alterarSituacao('alugado')}>Alugar</button>
          <button onClick={() => alterarSituacao('manutencao')}>Manutenção</button>
        </>
      )}

      {tarefa.status === 'alugado' && (
        <button onClick={() => alterarSituacao('disponivel')}>Devolver</button>
      )}

      {tarefa.status === 'manutencao' && (
        <button onClick={() => alterarSituacao('disponivel')}>Encerrar Manutenção</button>
      )}

      <button onClick={() => setIsEditModalOpen(true)}>Editar</button>
      <button onClick={deletarTarefa}>Deletar</button>

      {isAluguelModalOpen && (
        <div className="modal">
          <div className="modal-content">
            <h2>Registrar Aluguel</h2>
            <input
              placeholder="ID do Usuário"
              value={atribuirTarefa.id_usuario}
              onChange={(e) => setAtribuirTarefa({ ...atribuirTarefa, id_usuario: e.target.value })}
            />
            <input
              type="date"
              value={atribuirTarefa.data_cadastro}
              onChange={(e) => setAtribuirTarefa({ ...atribuirTarefa, data_cadastro: e.target.value })}
            />
            <button onClick={salvarTarefas}>Confirmar Aluguel</button>
            <button onClick={() => setIsAtribuirTarefaModalOpen(false)}>Cancelar</button>
          </div>
        </div>
      )}

      {isEditModalOpen && (
        <div className="modal">
          <div className="modal-content">
            <h2>Editar <Tarefa></Tarefa></h2>
            <input
              value={editedTar.descricao_tarefa}
              onChange={(e) => setEditedTar({ ...editedTar, descricao_tarefa: e.target.value })}
              placeholder="Descrição da tarefa"
            />
            <input
              value={editedTar.nome_setor}
              onChange={(e) => setEditedTar({ ...editedTar, nome_setor: e.target.value })}
              placeholder="Nome do Setor"
            />
            <input
              // type="number"
              value={editedTar.prioridade}
              onChange={(e) => setEditedTar({ ...editedTar, prioridade: (e.target.value) })}
              placeholder="Prioridade"
            />
            <button onClick={editarTarefa}>Salvar</button>
            <button onClick={() => setIsEditModalOpen(false)}>Cancelar</button>
          </div>
        </div>
      )}
    </div>
  );
}

export default Card;
