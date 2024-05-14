import React, { useEffect, useState } from 'react';
import styles from '../Style';
import { BsChevronCompactLeft, BsChevronCompactRight } from 'react-icons/bs';
import { Service } from '../components';
import useCategoryApi from '../api-layer/api-catogory';

const WorkServices = () => {
  const catogories = useCategoryApi();

  const [displayCatogories, setDisplayCatogories] = useState([0, 1, 2, 3]);

  const prevSlide = () => {
    const newArray = displayCatogories.map((categoryIndex) => {
      if (categoryIndex === 0) {
        return catogories.length - 1;
      } else {
        return categoryIndex - 1;
      }
    });

    setDisplayCatogories(newArray);
  };

  const nextSlide = () => {
    const newArray = displayCatogories.map((categoryIndex) => {
      if (categoryIndex === catogories.length - 1) {
        return 0;
      } else {
        return categoryIndex + 1;
      }
    });

    setDisplayCatogories(newArray);
  };

  return (
    <div className="content-container">
      <h1 className='font-poppins font-bold text-black md:mt-6 text-3xl'>
        Popular Services
      </h1>
      <div className={`flex flex-row justify-around relative`}>
        <div className='absolute left-4 top-1/2 transform -translate-y-1/2 rounded-full p-2 bg-black/30 text-white cursor-pointer' onClick={prevSlide}>
          <BsChevronCompactLeft size={30} />
        </div>
        <div className='absolute right-4 top-1/2 transform -translate-y-1/2 rounded-full p-2 bg-black/30 text-white cursor-pointer' onClick={nextSlide}>
          <BsChevronCompactRight size={30} />
        </div>
        {catogories.length > 0 && (
          displayCatogories.map((categoryIndex) => (
            <Service key={catogories[categoryIndex].id} {...catogories[categoryIndex]} />
          ))
        )}
      </div>
    </div>
  );
};

export default WorkServices;
