
import {  useState } from "react";

import axios from "axios";

function Appointment() {
  
    
  const [bloodtype, setBloodType] = useState("");
  const [day, setDay] = useState("");
  const [month, setMonth] = useState("");
  const [year, setYear] = useState("");

 
    


    async function save(event) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:8080/appointment", {
          bloodtype: bloodtype,
          day: day,
          month: month,
          year: year,
          });
          alert("Appointment Made Successfully");

        } catch (err) {
          alert(err);
        }
      }
  
    return (
    <div>
    <div class="container mt-4" >
    <div class="card">
            <h1>Make an appointment</h1>
    
    <form>
        <div class="form-group">
          <label>BloodType</label>
          <input type="text"  class="form-control" id="bloodtype" placeholder="Enter your bloodtype"
          
          value={bloodtype}
          onChange={(event) => {
            setBloodType(event.target.value);
          }}
          />

        </div>

        <div class="form-group">
          <label>Day</label>
          <input type="text"  class="form-control" id="day" placeholder="Enter the day"
          
          value={day}
          onChange={(event) => {
            setDay(event.target.value);
          }}
          
          />
 
        </div>

        <div class="form-group">
            <label>Month</label>
            <input type="text"  class="form-control" id="month" placeholder="Enter the month"
            
            value={month}
            onChange={(event) => {
              setMonth(event.target.value);
            }}
            
            />
              </div>
              <div class="form-group">
            <label>Year</label>
            <input type="text"  class="form-control" id="year" placeholder="Enter year"
            
            value={year}
            onChange={(event) => {
              setYear(event.target.value);
            }}
            
            />
          </div>

        <button type="submit" class="btn btn-primary mt-4" onClick={save} >Register</button>
       
      </form>
    </div>
    </div>
     </div>
    );
  }
  
  export default Appointment;