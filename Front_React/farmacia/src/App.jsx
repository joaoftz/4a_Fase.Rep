// src/App.js
import React from 'react';
import Header from './components/Header';
import Body from './components/Body';
import './App.css';

const App = () => {
  return (
    <div className="renderContainer">
      <Header />
      <Body />
    </div>
  );
};

export default App;
