import { useState, useEffect } from "react";

const useCategoryApi = () => {

    const [catogories, setCatogories] = useState([])

    const fetchUserData = () => {
      fetch("http://localhost:8080/catogories")
        .then(response => {
          return response.json()
        })
        .then(data => {
            setCatogories(data.catogories)
        })
    }
  
    useEffect(() => {
      fetchUserData()
    }, [])

  return catogories;
};

export default useCategoryApi;
