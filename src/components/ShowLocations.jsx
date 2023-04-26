import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { useNavigate } from 'react-router-dom';

function ShowLocations()
{
  const navigate = useNavigate();  
  const [locations, setLocations] = useState([])
    useEffect(() => { 
        loadLocations();
    });
    
    const loadLocations = async () => {
        const result = await axios.get("http://localhost:8080/locations");
        setLocations(result.data);

    }
    return (
        <div className="container">
        <div className="py-4">
          <table className="table border shadow">
            <thead>
                        <tr>
                <th scope = "col">ID</th>
                <th scope="col">Nume</th>
                <th scope="col">Inceput</th>
                <th scope="col">Final</th>
              </tr>
            </thead>
            <tbody>
              {locations.map((user, index) => (
                <tr>
                  <th scope="row" key={index}>
                    {index + 1}
                  </th>
                  <td>{user.name}</td>
                  <td>{user.inceput}</td>
                  <td>{user.sfarsit}</td>
                  <td>
                  <Link
                      className="btn btn-primary mx-2"
                      to={`/appointment`}
                    >
                      Make appointment here
                    </Link>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
}
export default ShowLocations;