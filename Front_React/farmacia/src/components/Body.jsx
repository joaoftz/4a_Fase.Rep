import React from 'react';
import ControladorDeSenhas from './ControleSenhas';

const Body = () => {
  return (
    <main style={styles.body}>
      <h2>Bem-vindo ao Sistema de Gestão de Filas</h2>
      <p>Escolha a opção desejada para gerar ou chamar senhas.</p>
      <ControladorDeSenhas />
    </main>
  );
};

const styles = {
  body: {
    padding: '20px',
    textAlign: 'center',
  }
};

export default Body;
