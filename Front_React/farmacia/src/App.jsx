// App.jsx
import React, { useState } from 'react';
import './App.css';
import Header from './components/Header';
import Body from './components/Body';
import MenuBar from './components/MenuBar';
import PasswordPage from './components/PasswordPage';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  const [normalQueue, setNormalQueue] = useState([]);
  const [preferentialQueue, setPreferentialQueue] = useState([]);
  const [currentPassword, setCurrentPassword] = useState(null);



  return (
    <Router>
      <div className='all'>
        <Header />
        <MenuBar />
        <Routes>
          <Route path="/" element={
            <Body 
              normalQueue={normalQueue}
              preferentialQueue={preferentialQueue}
              setNormalQueue={setNormalQueue}
              setPreferentialQueue={setPreferentialQueue}
              setCurrentPassword={setCurrentPassword}
            />
          } />
          <Route path="/senhas" element={
            <PasswordPage 
              normalQueue={normalQueue} 
              preferentialQueue={preferentialQueue} 
              currentPassword={currentPassword} 
            />
          } />
        </Routes>
        <img className="footer" src="./public/farmarcia.png" alt="" />
        <p> camisa na promoção </p>
  
        <img src="./public/farmarcia-camiseta.png" alt="" />
      </div>
    </Router>
  );
}

export default App;
