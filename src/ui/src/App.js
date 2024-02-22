
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Layout from "./pages/Layout";
import Home from "./pages/Home";
import Customers from "./pages/Customers";
import Services from "./pages/Services";
import Vendors from "./pages/Vendors";
import Product from "./pages/Product";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path={"/"} element={<Layout/>}>
              <Route index element={<Home/>}/>
              <Route path={'customers'} element={<Customers/>}/>
              <Route path={"services"} element={<Services/>}/>
              <Route path={"vendors"} element={<Vendors/>}/>
              <Route path={"products"} element={<Product/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
