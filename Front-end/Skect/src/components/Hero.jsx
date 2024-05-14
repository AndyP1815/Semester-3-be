import React from 'react'
import styles from '../Style'
import {icon,HeroImg} from "../assets"
const Hero = () =>  (

    <section id='home' className={` flex md:flex-row flex-col ${styles.paddingY}`} >
      <div className={`flex 1 ${styles.flexStart} flex-col xl:px-0 sm:px-16 px-6`}>
        <div className='flex flex-row justify-between items-center w-full'>
          <h1 className='flex-1 font-poppins font-bold italic text-[52px]
           leading-[75px] ' >
            The <br/>{" "}
            <span className='text-world'>World <br/>{" "}
            </span>
            Opens up <br/>{" "} 
           <span >
            <span className='text-here'>Here</span>
            <span className='icon image-text'>
              <img src={icon} alt="Icon" />
              </span>
              <br />
              </span>  
              </h1>
              <div className='w-[50%] h-[auto] relative z-[5] md:ml-8 mt-[-60px]'>
          <img src={HeroImg} alt='Freelance' className='w-full h-auto' />
          <form>
            <div className="max-w-xl md:ml-8">
              <div className="flex space-x-4">
                <div className="flex rounded-md overflow-hidden w-full">
                <input type="text" className="w-full rounded-md rounded-r-none px-4 py-2 text-gray-800 font-semibold text-lg" placeholder="Search..." />
                  <button className="bg-indigo-600 text-white px-6 text-lg font-poppins py-4 rounded-r-md">Go</button>
                </div>
              </div>
            </div>
        </form>
        </div>
        

        </div>

      </div>
     

      </section>
  )


export default Hero