import React, { useEffect, useState } from 'react';
import Card from './components/Card';

function App() {
  const [tarefas, setTarefas] = useState([]);
  const [usuarios, setUsuarios] = useState([]);
  const [isAddingTarefa, setIsAddingTarefa] = useState(false);
  const [isAddingUsuario, setIsAddingUsuario] = useState(false);
  const [novaTarefa, setNovaTarefa] = useState({
    descricao_tarefa: '',
    nome_setor: '',
    prioridade: '',
  });
  const [novoUsuario, setNovoUsuario] = useState({
    nome: '',
    email: '',
  });

  // versão compacta que serve para todos os status
  const filtroTarefasPorStatus = (status) => tarefas.filter(tarefa => tarefa.status === status);

  // versão para criar uma função para cada status diferente (usei no disponivel para exemplificar)
  function filtrarDisponiveis(){
    return tarefas.filter(tarefa => tarefa.status === 'a fazer');
  }

  function adicionarTarefa() {
    setIsAddingTarefa(true);
  }

  function adicionarUsuario() {
    setIsAddingUsuario(true);
  }

  const salvarTarefa = async () => {
    try {
      await fetch('http://localhost:3000/tarefas', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(novaTarefa),
      });
      setIsAddingTarefa(false);
      setNovaTarefa({ descricao_tarefa: '', nome_setor: '', email: '' });
      buscarTarefas();
    } catch (error) {
      console.error('Erro ao salvar Tarefa:', error);
    }
  };

  const salvarUsuario = async () => {
    try {
      await fetch('http://localhost:3000/usuarios', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(novoUsuario),
      });
      setIsAddingUsuario(false);
      setNovoUsuario({ nome: '', email: '' });
      buscarUsuarios();
    } catch (error) {
      console.error('Erro ao salvar usuario:', error);
    }
  };

  const buscarTarefas = async () => {
    try {
      const response = await fetch('http://localhost:3000/tarefas');
      const data = await response.json();
      setTarefas(data);
    } catch (error) {
      console.error('Erro ao buscar Tarefas:', error);
    }
  };

  const buscarUsuarios = async () => {
    try {
      const response = await fetch('http://localhost:3000/usuarios');
      const data = await response.json();
      setClientes(data);
    } catch (error) {
      console.error('Erro ao buscar Tarefas:', error);
    }
  };

  useEffect(() => {
    buscarTarefas();
    buscarUsuarios();
  }, []);

  return (
    <div>
      <header>
        <h1>Gerenciamento de Tarefas</h1>
        <button onClick={adicionarTarefa}>Adicionar Tarefa</button>
        <button onClick={adicionarUsuario}>Adicionar Usario</button>
      </header>
      <div className="dashboard">
        <div className="coluna-dashboard">
          <h2>A Fazer</h2>
          {/* {filtroCarrosPorStatus('disponivel').map(carro => (
            <Card key={carro.id} carro={carro} buscarCarros={buscarCarros} clientes={clientes} />
          ))} */}
          {filtrarDisponiveis().map(tarefa => (
            <Card key={tarefa.id} tarefa={tarefa} buscarTarefas={buscarTarefas} usuarios={usuarios} />
          ))}
        </div>
        <div className="coluna-dashboard">
          <h2>Fazendo</h2>
          {filtroTarefasPorStatus('fazendo').map(tarefa => (
            <Card key={tarefa.id} tarefa={tarefa} buscarTarefas={buscarTarefas} usuarios={usuarios} />
          ))}
        </div>
        <div className="coluna-dashboard">
          <h2>Pronto</h2>
          {filtroTarefasPorStatus('pronto').map(tarefa => (
            <Card key={tarefa.id} tarefa={tarefa} buscarTarefas={buscarTarefas} usuarios={usuarios} />
          ))}
        </div>
      </div>
      {isAddingTarefa && (
        <div className="modal">
          <div className="modal-content">
            <h2>Adicionar Tarefa</h2>
            <input
              placeholder="descricao da tarefa"
              value={novaTarefa.descricao_tarefa}
              onChange={(e) => setNovaTarefa({ ...novaTarefa, descricao_tarefa: e.target.value })}
            />
            <input
              placeholder="nome do setor"
              value={novaTarefa.nome_setor}
              onChange={(e) => setNovaTarefa({ ...novaTarefa, nome_setor: e.target.value })}
            />
            <input
              // type="number"
              placeholder="prioridade"
              value={novaTarefa.prioridade}
              onChange={(e) => setNovaTarefa({ ...novaTarefa, prioridade: e.target.value })}
            />
            <button onClick={salvarTarefa}>Salvar</button>
            <button onClick={() => setIsAddingTarefa(false)}>Cancelar</button>
          </div>
        </div>
      )}
      {isAddingUsuario && (
        <div className="modal">
          <div className="modal-content">
            <h2>Adicionar usuario</h2>
            <input
              placeholder="Nome"
              value={novoUsuario.nome}
              onChange={(e) => setNovoUsuario({ ...novoUsuario, nome: e.target.value })}
            />
            <input
              placeholder="Email"
              value={novoUsuario.email}
              onChange={(e) => setNovoUsuario({ ...novoUsuario, email: e.target.value })}
            />
            <button onClick={salvarUsuario}>Salvar</button>
            <button onClick={() => setIsAddingUsuario(false)}>Cancelar</button>
          </div>
        </div>
      )}
    </div>
  );
}

export default App;