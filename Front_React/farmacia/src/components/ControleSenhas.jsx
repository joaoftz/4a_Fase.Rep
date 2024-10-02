// src/components/ControladorDeSenhas.js
import React, { useState } from 'react';

const ControladorDeSenhas = () => {
  const [filaNormal, setFilaNormal] = useState([]);
  const [filaPreferencial, setFilaPreferencial] = useState([]);
  const [ultimaChamada, setUltimaChamada] = useState(null);
  const [proximoIdNormal, setProximoIdNormal] = useState(1);
  const [proximoIdPreferencial, setProximoIdPreferencial] = useState(1);

  const gerarSenhaNormal = () => {
    setFilaNormal([...filaNormal, proximoIdNormal]);
    setProximoIdNormal(proximoIdNormal + 1);
  };

  const gerarSenhaPreferencial = () => {
    setFilaPreferencial([...filaPreferencial, proximoIdPreferencial]);
    setProximoIdPreferencial(proximoIdPreferencial + 1);
  };

  const chamarProximaSenha = () => {
    if (filaPreferencial.length > 0) {
      const proximaPreferencial = filaPreferencial.shift();
      setUltimaChamada(`P-${proximaPreferencial}`);
      setFilaPreferencial([...filaPreferencial]);
    } else if (filaNormal.length > 0) {
      const proximaNormal = filaNormal.shift();
      setUltimaChamada(`N-${proximaNormal}`);
      setFilaNormal([...filaNormal]);
    } else {
      setUltimaChamada('Fila vazia');
    }
  };

  return (
    <div className="controlador-de-senhas">
      <h2>Fila de Senhas</h2>
      <button onClick={gerarSenhaNormal}>Gerar Senha Normal</button>
      <button onClick={gerarSenhaPreferencial}>Gerar Senha Preferencial</button>
      <button onClick={chamarProximaSenha}>Chamar Próxima Senha</button>
      <h3>Senha Atual: {ultimaChamada || 'Nenhuma senha chamada'}</h3>
      <h4>Senhas na fila:</h4>
      <p>Normal: {filaNormal.join(', ') || 'Nenhuma'}</p>
      <p>Preferencial: {filaPreferencial.join(', ') || 'Nenhuma'}</p>
    </div>
  );
};

export default ControladorDeSenhas;
