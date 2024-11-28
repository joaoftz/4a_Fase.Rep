const express = require('express');
const cors = require('cors');
const { Pool } = require('pg');

const app = express();

const pool = new Pool({
  user: 'postgres',
  host: 'localhost',
  database: 'saep',
  password: 'senai',
  port: 5432,
});

// const pool = new Pool({
//     user: 'local', // Substitua pelo seu usuário do PostgreSQL
//     host: 'localhost',
//     database: 'alugaCarros', // Nome da sua database
//     password: '12345', // Substitua pela sua senha
//     port: 5432, // Porta padrão do PostgreSQL
// });

app.use(cors());
app.use(express.json());

app.get('/tarefas', async (req, res) => {
  try {
    const result = await pool.query('SELECT * FROM tarefas');
    res.json(result.rows);
  } catch (err) {
    console.error(err.message);
    res.status(500).json({ error: 'Erro ao buscar tarefas' });
  }
});

app.get('/tarefas/:id', async (req, res) => {
  const { id } = req.params;
  try {
    const result = await pool.query('SELECT * FROM tarefas WHERE id = $1', [id]);
    if (result.rows.length === 0) {
      return res.status(404).json({ error: 'tarefa não encontrado' });
    }
    res.json(result.rows[0]);
  } catch (err) {
    console.error(err.message);
    res.status(500).json({ error: 'Erro ao buscar tarefa' });
  }
});

app.post('/tarefas', async (req, res) => {
  const { descricao_tarefa, nome_setor, prioridade } = req.body;
  try {
    const result = await pool.query(
      'INSERT INTO tarefas (descricao_tarefa, nome_setor, prioridade) VALUES ($1, $2, $3) RETURNING *',
      [descricao_tarefa, nome_setor, prioridade]
    );
    res.status(201).json(result.rows[0]);
  } catch (err) {
    console.error(err.message);
    res.status(500).json({ error: 'Erro ao adicionar carro' });
  }
});

app.put('/tarefas/:id', async (req, res) => {
  const { id } = req.params;
  const { descricao_tarefa, nome_setor, prioridade, id_usuario, data_cadastro, status } = req.body;
  try {
    const result = await pool.query(
      'UPDATE tarefas SET descricao_tarefa = $1, nome_setor = $2, prioridade = $3, id_usuario = $4, data_cadastro = $5, status = $6 WHERE id = $7 RETURNING *',
      [descricao_tarefa, nome_setor, prioridade, id_usuario, data_cadastro, status, id]
    );
    if (result.rows.length === 0) {
      return res.status(404).json({ error: 'Carro não encontrado' });
    }
    res.json(result.rows[0]);
  } catch (err) {
    console.error(err.message);
    res.status(500).json({ error: 'Erro ao atualizar carro' });
  }
});

app.delete('/tarefas/:id', async (req, res) => {
  const { id } = req.params;
  try {
    const result = await pool.query('DELETE FROM tarefas WHERE id = $1 RETURNING *', [id]);
    if (result.rows.length === 0) {
      return res.status(404).json({ error: 'Tarefa não encontrada' });
    }
    res.json({ message: 'Tarefa deletada com sucesso' });
  } catch (err) {
    console.error(err.message);
    res.status(500).json({ error: 'Erro ao deletar tarefa' });
  }
});

app.post('/usuarios', async (req, res) => {
  const { nome, email } = req.body;
  try {
    const result = await pool.query(
      'INSERT INTO usuarios (nome, email) VALUES ($1, $2) RETURNING *',
      [nome, email]
    );
    res.status(201).json(result.rows[0]);
  } catch (err) {
    console.error(err.message);
    res.status(500).json({ error: 'Erro ao adicionar usuario' });
  }
});

app.get('/usuarios', async (req, res) => {
  try {
    const result = await pool.query('SELECT * FROM usuarios');
    res.json(result.rows);
  } catch (err) {
    console.error(err.message);
    res.status(500).json({ error: 'Erro ao buscar usuarios' });
  }
});

app.listen(3000, () => {
  console.log('Servidor rodando na porta 3000');
});