import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import About from './Pages/AboutUs';
import Join from './Pages/LogIn';
import Discover from './Pages/Discover';
import Home from './Pages/Home';
import { Navbar, Hero, Promo, WorkServices, Footer, Users } from './components';
import styles from './Style';

const App = () => {
  return (
    <Router>
      <div className="bg-white w-full overflow-hidden">
        <div className={`${styles.paddingX} ${styles.flexCenter}`}>
          <div className={`${styles.boxWidth}`}>
            <Navbar />
          </div>
        </div>

        <div>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/join" element={<Join />} />
            <Route path="/discover" element={<Discover />} />
            <Route path="/aboutUs" element={<About />} />
          </Routes>
         
        </div>
      </div>
    </Router>
  );
}

export default App;
