import React, { useState } from "react";
import "./App.css";
import axios from "axios";

const api = "http://localhost:9559/update";

const App = () => {
  const [form, setForm] = useState({
    name: "",
    emailid: "",
    date: "",
    feez: "",
    number: "",
    gender: "",
    address: "",
    age: "",
    bloodtest: "",
    sugartest: "",
  });

  const [errors, setErrors] = useState({});

  // Handle field change
  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
    setErrors({ ...errors, [e.target.name]: "" });
  };

  // Validate form
  const validateForm = () => {
    let newErrors = {};

    if (!form.name || form.name.trim().length < 3) {
      newErrors.name = "Name must be at least 3 characters long";
    }

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!form.emailid || !emailPattern.test(form.emailid)) {
      newErrors.emailid = "Invalid email id";
    }

    if (!form.number || !/^[6-9]\d{9}$/.test(form.number)) {
      newErrors.number = "Mobile number must be 10 digits starting with 6-9";
    }

    if (!form.age || isNaN(form.age) || form.age < 1 || form.age > 120) {
      newErrors.age = "❌ Enter a valid age (1-120)";
    }

    if (!form.gender) {
      newErrors.gender = "❌ Gender is required";
    }

    if (!form.feez || isNaN(form.feez) || form.feez <= 0) {
      newErrors.feez = "Fee must be a positive number";
    }

    if (!form.date) {
      newErrors.date = "Date is required";
    }

    if (!form.address || form.address.trim().length < 3) {
      newErrors.address = "Address must be at least 5 characters";
    }

    if (!form.bloodtest) {
      newErrors.bloodtest = "Blood test result is required";
    }

    if (!form.sugartest) {
      newErrors.sugartest = "Sugar test result is required";
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  // Handle form submit
  const handleSubmit = async () => {
    if (!validateForm()) {
      alert("❌ Please fix validation errors before submitting.");
      return;
    }

    try {
      const { data } = await axios.post(api, form);
      alert("✅ Patient details inserted successfully!");
      console.log("Response:", data);

      // Clear form after success
      setForm({
        name: "",
        emailid: "",
        date: "",
        feez: "",
        number: "",
        gender: "",
        address: "",
        age: "",
        bloodtest: "",
        sugartest: "",
      });

    } catch (error) {
      console.error("Error:", error);
      alert("❌ Failed to update patient details.");
    }
  };

  return (
    <div className="registration-container">
      <h2 className="login" style={{ color: "blue" }}>👨🏻‍⚕️ Hospital updation Form 👩🏻‍⚕️</h2>

      <input name="name" placeholder="Name" value={form.name} onChange={handleChange} />
      {errors.name && <p className="error">{errors.name}</p>}

      <input name="emailid" placeholder="Email" value={form.emailid} onChange={handleChange} />
      {errors.emailid && <p className="error">{errors.emailid}</p>}

      <input name="number" placeholder="Mobile Number" value={form.number} onChange={handleChange} />
      {errors.number && <p className="error">{errors.number}</p>}

      <input name="age" placeholder="Age" value={form.age} onChange={handleChange} />
      {errors.age && <p className="error">{errors.age}</p>}

      <input name="gender" placeholder="Gender" value={form.gender} onChange={handleChange} />
      {errors.gender && <p className="error">{errors.gender}</p>}

      <input name="date" type="date" value={form.date} onChange={handleChange} />
      {errors.date && <p className="error">{errors.date}</p>}

      <input name="feez" placeholder="Fee" value={form.feez} onChange={handleChange} />
      {errors.feez && <p className="error">{errors.feez}</p>}

      <input name="address" placeholder="Address" value={form.address} onChange={handleChange} />
      {errors.address && <p className="error">{errors.address}</p>}

      <input name="bloodtest" placeholder="Blood Test Result" value={form.bloodtest} onChange={handleChange} />
      {errors.bloodtest && <p className="error">{errors.bloodtest}</p>}

      <input name="sugartest" placeholder="Sugar Test Result" value={form.sugartest} onChange={handleChange} />
      {errors.sugartest && <p className="error">{errors.sugartest}</p>}

      <button style={{ marginTop: "20px", fontSize: "20px" }} onClick={handleSubmit}>Submit</button>
    </div>
  );
};

export default App;
