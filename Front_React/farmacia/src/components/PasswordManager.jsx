// PasswordManager.jsx
import React, { useState } from 'react';
import './PasswordManager.css';
import QueueDisplay from './Display';

function PasswordManager() {
  const [normalQueue, setNormalQueue] = useState([]);
  const [preferentialQueue, setPreferentialQueue] = useState([]);
  const [currentPassword, setCurrentPassword] = useState(null);

  const generateNormalPassword = () => {
    const newPassword = `N${normalQueue.length + preferentialQueue.length + 1}`;
    setNormalQueue([...normalQueue, newPassword]);
  };

  const generatePreferentialPassword = () => {
    const newPassword = `P${preferentialQueue.length + 1}`;
    setPreferentialQueue([...preferentialQueue, newPassword]);
  };

  const callNextPassword = () => {
    if (preferentialQueue.length > 0) {
      const nextPassword = preferentialQueue[0];
      setCurrentPassword(nextPassword);
      setPreferentialQueue(preferentialQueue.slice(1));
    } else if (normalQueue.length > 0) {
      const nextPassword = normalQueue[0];
      setCurrentPassword(nextPassword);
      setNormalQueue(normalQueue.slice(1));
    } else {
      alert('A fila está vazia!');
    }
  };

  return (
    <div className="password-manager">
      <button onClick={generateNormalPassword}>Gerar Senha Normal</button>
      <button onClick={generatePreferentialPassword}>Gerar Senha Preferencial</button>
      <button onClick={callNextPassword}>Chamar Próxima Senha</button>
      <QueueDisplay 
        normalQueue={normalQueue} 
        preferentialQueue={preferentialQueue} 
        currentPassword={currentPassword} 
      />
    </div>
  );
}

export default PasswordManager;
