import logo from './logo.svg';
import './App.css';
import {
    BrowserRouter as Router,
    Route,
    Routes as Switch,
    Navigate as Redirect
} from "react-router-dom";
//import Administration from './Administration';
import Login from './Login';
import Home from "./Home";
import MyList from './MyList';
import Search from './Search';
import Movie from './Movie';
import Admin from './Admin';
import Actor from './Actor';


function App() {
    const defaultRoute = window.location.pathname === "/" ? <Redirect to="/log-in"/> : undefined;

    return (
     
        <Router>
            <Switch>
                <Route exact path="/log-in" element={<Login/>}/>
              
                <Route exact path="/home" element={<Home/>}/>

                <Route exact path="/mylist" element={<MyList/>}/>

                <Route exact path="/search" element={<Search/>}/>

                <Route exact path="/movie" element={<Movie/>}/>

                <Route exact path="/admin" element={<Admin/>}/>

                <Route exact path="/actor" element={<Actor/>}/>

            </Switch>
            {defaultRoute}
        </Router>
    );
}

export default App;