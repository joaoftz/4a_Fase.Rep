import './Header.css'
import { PiggyBankLine } from './icons/PiggyBankLine'

function Header() {
  const iconBig= {
    width: '148px',
    height: '1480px'
  };
  return (
    <div className="header-container">
      <h1>Página bonita</h1>
      <PiggyBankLine/>
    </div>
  )
}

export default Header
