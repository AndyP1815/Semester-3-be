import React, { useState } from 'react';
import styles from '../Style';
import { WorkProviders } from '../Constants/Index';
import { BsChevronCompactLeft, BsChevronCompactRight } from 'react-icons/bs';
import {User,Service} from '../components'




const Users = () => {
  
  const [displayPeople, setDisplayPeople] = useState([0, 1, 2, 3]);

  const prevSlide = () => {
  
    const newArray = displayPeople.map((Peopleindex) => {
      if (Peopleindex === 0) {
        return WorkProviders.length - 1;
      } else {
        return Peopleindex - 1;
      }
    });

    setDisplayPeople(newArray);
  };

  const nextSlide = () => {
    const newArray = displayPeople.map((Peopleindex) => {
      if (Peopleindex === WorkProviders.length - 1) { 
        return 0;
      } else {
        return Peopleindex + 1;
      }
    });

    setDisplayPeople(newArray);
  };


  return (
    

    <div className="content-container md:mb-20 ">
      <h1 className=' font-poppins font-bold text-black md:mt-6 text-3xl'
      > Meet People</h1>
      <div className={`flex flex-row justify-around relative`}>
        <div className='absolute left-4 top-1/2 transform -translate-y-1/2 rounded-full p-2 bg-black/30 text-white cursor-pointer' onClick={prevSlide}>
          <BsChevronCompactLeft size={30} />
        </div>
        <div className='absolute right-4 top-1/2 transform -translate-y-1/2 rounded-full p-2 bg-black/30 text-white cursor-pointer' onClick={nextSlide}>
          <BsChevronCompactRight size={30} />
        </div>
        {
        displayPeople.map((Peopleindex) => (
          <User key={WorkProviders[Peopleindex].id} {...WorkProviders[Peopleindex]} />
        ))}
      
      </div>
    </div>
  );
};

export default Users;
