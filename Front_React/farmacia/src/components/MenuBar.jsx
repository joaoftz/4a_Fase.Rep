// MenuBar.jsx
import React from 'react';
import { Link } from 'react-router-dom';
import './MenuBar.css';

function MenuBar() {
  return (
    <nav className="menu-bar">
      <Link to="/">Início</Link>
      <Link to="/senhas">Senhas</Link>
    </nav>
  );
}

export default MenuBar;
