import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import UsuarioLogado from './components/UsuarioLogado'
import AreaParaAdultos from './components/AreaParaAdultos.'
import EfetueLogin from './components/EfetueLogin'

function App() {
  const [usuario, setUsuario] = useState(false)
  const [idade, setIdade ]  = useState(0)


  return (
    <>

      
      <div className="renderContainer">       
      { usuario &&  <UsuarioLogado /> }
      <button onClick={ () => {setUsuario(true)} }>Logar</button>
      <button onClick={ () => setUsuario(false) }>Deslogar</button>
      </div>

      <div className="renderContainer">
        <button onClick={() => {setIdade(idade -1)}}>-</button>
        {idade }
        <button onClick={() => {setIdade(idade +1)}}>+</button>
        { idade>=18 && <AreaParaAdultos />}
      </div>
      

      <div className="renderContainer">
        { usuario ? <UsuarioLogado /> : <EfetueLogin /> }
      </div>
      

    </>
  )
}

export default App
