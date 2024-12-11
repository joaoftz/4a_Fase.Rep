// QueueDisplay.jsx
import React from 'react';
import './Display.css';

function QueueDisplay({ normalQueue, preferentialQueue, currentPassword }) {
  return (
    <div className="queue-display">
      <h3>Fila de Senhas</h3>
      <div>
        <h4>Preferenciais</h4>
        {preferentialQueue.length > 0 ? (
          <ul>
            {preferentialQueue.map((password, index) => (
              <li key={index}>{password}</li>
            ))}
          </ul>
        ) : (
          <p>Nenhuma senha preferencial na fila.</p>
        )}
      </div>
      <div>
        <h4>Normais</h4>
        {normalQueue.length > 0 ? (
          <ul>
            {normalQueue.map((password, index) => (
              <li key={index}>{password}</li>
            ))}
          </ul>
        ) : (
          <p>Nenhuma senha normal na fila.</p>
        )}
      </div>
      <div className="current-password">
        <h4>Senha Chamada:</h4>
        <p>{currentPassword || 'Nenhuma senha chamada'}</p>
      </div>
    </div>
  );
} 

export default QueueDisplay;
