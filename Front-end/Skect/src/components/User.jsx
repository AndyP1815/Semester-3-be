import React from 'react'

const User = ({name,image,role,profile}) => {
  return(
    <div className="flex flex-col max-w-md p-6 ">
    <img src={image} alt="" className="flex-shrink-0 object-cover rounded-sm sm:h-60 w-80 dark:bg-gray-500 aspect-square" />
    <div className=' bg-white flex flex-row justify-around pt-3 pb-3 pl-2 pr-2'>
    <img  className="flex-shrink-0 object-cover w-8 h-8 rounded-full sm:h-24 sm:w-24 dark:bg-gray-500 mr-2" src={profile}/> 
      <div className=' flex flex-col pt-5'>
      <h2 className="text-xl font-semibold">{name}</h2>
      <span className="block pb-2 text-sm dark:text-gray-400 ">{role}</span>
      </div>

    </div>
  </div>
  )
};


export default User