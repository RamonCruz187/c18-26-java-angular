import React, { useEffect, useState } from 'react';
import axios from './axios'; // Asegúrate de importar la configuración de axios

const ExampleComponent = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios.get('/endpoint');
      setData(result.data);
    };
    fetchData();
  }, []);

  return (
    <div>
      <h1>Data from Backend</h1>
      <ul>
        {data.map(item => (
          <li key={item.id}>{item.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default ExampleComponent;
