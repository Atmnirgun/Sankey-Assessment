import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import ListEmployeeComponent from './componentes/ListEmployeeComponent'
import HeaderComponent from './componentes/HeaderComponent';
import FooterComponent from './componentes/FooterComponent';
import CreateEmployeeComponent from './componentes/CreateEmployeeComponent';
import ViewEmployeeComponent from './componentes/ViewEmployeeComponent';

function App() {
  return (
    <div>
      <Router>
        <div className='container'>
          <HeaderComponent />
          <div>
            <Routes>
              <Route path='/' exact element={<ListEmployeeComponent />} />
              <Route path='/employees' element={<ListEmployeeComponent />} />
              <Route path = "/add-employee/:id" element = {<CreateEmployeeComponent />} />
              <Route path = "/view-employee/:id" element = {<ViewEmployeeComponent />} />
            </Routes>
          </div>
          <FooterComponent />
        </div>
      </Router>
    </div> 
  );
}

export default App;
