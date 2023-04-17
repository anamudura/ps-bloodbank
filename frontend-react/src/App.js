import { BrowserRouter,Routes,Route } from "react-router-dom";
import Login from "./components/Login"
import Register from "./components/Register";
import AdminPage from "./components/AdminPage";
import DoctorPage from "./components/DoctorPage";
import DonatorPage from "./components/DonatorPage";
import DonatorAction from "./components/DoctorAction";



function App() {
  return (
    <div>

      <BrowserRouter>
            <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/admin" element={<AdminPage />} />
          <Route path="/doctor" element={<DoctorPage />} />
          <Route path="/donator" element={<DonatorPage />} />
          <Route path="/users" element={<DonatorAction />} />
            </Routes>
        </BrowserRouter>
      
    </div>
  );
}

export default App;