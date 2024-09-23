import { useState } from 'react'

import './App.css'
import Portifolio from './pages/Portifolio'
import Home from './pages/Home'

function App() {
  const [pagina, setPagina] = useState(<Home />)

  return (
    <>
      <nav>
        <button onClick={ () => setPagina(<Home />)}>Home</button>
        <button onClick={ () => setPagina(<Viagens />)}>Viagens</button>
        <button onClick={ () => setPagina(<Portifolio />)}>Portifólio</button>
      </nav>
      { pagina }
    </>
  )
}

export default App
