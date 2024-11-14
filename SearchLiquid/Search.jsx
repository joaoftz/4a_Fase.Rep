import React, { useState, useEffect } from 'react';
import './Search.css';
import Sidebar from '../SideBar';

const Search = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [recentSearches, setRecentSearches] = useState([]);

  // Carregar pesquisas recentes do localStorage ao montar o componente
  useEffect(() => {
    const storedSearches = JSON.parse(localStorage.getItem('pesquisasRecentes')) || [];
    setRecentSearches(storedSearches);
  }, []);

  // Salvar nova pesquisa
  const handleSearch = () => {
    if (searchTerm.trim()) {
      const updatedSearches = [searchTerm, ...recentSearches.slice(0, 4)]; // Limita a 5 itens
      setRecentSearches(updatedSearches);
      localStorage.setItem('pesquisasRecentes', JSON.stringify(updatedSearches));
      setSearchTerm('');
    }
  };

  // Apagar todas as pesquisas
  const clearSearches = () => {
    setRecentSearches([]);
    localStorage.removeItem('pesquisasRecentes');
  };

  // Remover uma pesquisa específica
  const removeSearchItem = (index) => {
    const updatedSearches = recentSearches.filter((_, i) => i !== index);
    setRecentSearches(updatedSearches);
    localStorage.setItem('pesquisasRecentes', JSON.stringify(updatedSearches));
  };

  return (
    <>
      <div>
        <Sidebar />
      </div>
      <div className="search-panel">
        <input
          type="text"
          placeholder="Pesquisar"
          className="search-input"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          onKeyPress={(e) => e.key === 'Enter' && handleSearch()}
        />
        <div className="recent-searches">
          <h3>Recentes</h3>
          {recentSearches.length > 0 ? (
            recentSearches.map((item, index) => (
              <div key={index} className="search-item">
                <span>{item}</span>
                <button
                  className="delete-button"
                  onClick={() => removeSearchItem(index)}
                >
                  ✕
                </button>
              </div>
            ))
          ) : (
            <p className="search-item">Nenhuma pesquisa recente</p>
          )}
          <button className="clear-button" onClick={clearSearches}>Apagar tudo</button>
        </div>
      </div>
    </>
  );
};

export default Search;
