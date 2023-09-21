
import { Alert, AppBar, Autocomplete, Box, Button, CardMedia, Card ,IconButton, Menu, MenuItem, Snackbar, TextField, Toolbar, Typography } from '@mui/material'
import HomeIcon from '@mui/icons-material/Home';
import React from 'react'
import classes from './CSS/Movie.module.scss'
import axiosInstance from "./axios";
import SideNav, { Toggle, Nav, NavItem, NavIcon, NavText } from '@trendmicro/react-sidenav';
import history from './history';
import css from './CSS/Search.module.scss';



class Search extends React.Component {


    constructor() {
        super()
        this.state = {
            movies: [],
            actors: []
        }
    };



    handle = (selected) => {
        const to = '/' + selected;
        if (location.pathname !== to) {
            if(to == '/log-in')
            {
                axiosInstance.post("/logout", localStorage.getItem('USER_ID'))
                .then(
                    res => {
                        
                    }
                )
                .catch(error => {
                    console.log(error)
                })
                localStorage.removeItem('USER_ID');
                console.log(to);
                history.push(to);
                window.location.reload();
            }else
            {
                if(to=="/home" && localStorage.getItem("user")=="admin@gmail.com")
                {
                    console.log(to);
                    history.push("/admin");
                    window.location.reload();
                }else
                {
                console.log(to);
                history.push(to);
                window.location.reload();
                }
               
            }
           
        }
        }
    

        componentDidMount(){
            console.log(localStorage.getItem('USER_ID'));
            axiosInstance.post("/getAllMovies")
            .then(
                res => {
                    const val = res.data;
                    
                    this.setState(
                        {
                            movies: val
                        }       
                    );
                    console.log(val);
                    //console.log(this.state);
                }
            )
            .catch(error => {
                console.log(error)
            })

            axiosInstance.post("/getAllActors")
            .then(
                res => {
                    const val = res.data;
                    
                    this.setState(
                        {
                            actors: val
                        }       
                    );
                    console.log(val);
                    console.log(this.state.actors.imagePatha);
                }
            )
            .catch(error => {
                console.log(error)
            })
        }


        handleClick (m) {
            localStorage.setItem('movieId', m )
            history.push("/movie");
            window.location.replace('http://localhost:3000/movie')
        }

        handleClickActor (a) {
            localStorage.setItem('actorId', a )
            history.push("/actor");
            window.location.replace('http://localhost:3000/actor')
        }
    

render() {
        return(
                <div>

                            <SideNav
                             onSelect={this.handle}

                            >
                            <SideNav.Toggle />
                            <SideNav.Nav defaultSelected="search">
                                <NavItem eventKey="home">
                                    <NavIcon>
                                        <i className="fa fa-fw fa-home" style={{ fontSize: '1.75em' }} />
                                    </NavIcon>
                                    <NavText>
                                        Home
                                    </NavText>
                                </NavItem>
                                <NavItem eventKey="mylist">
                                    <NavIcon>
                                        <i className="fa fa-fw fa-home" style={{ fontSize: '1.75em' }} />
                                    </NavIcon>
                                    <NavText>
                                        My Movie List
                                    </NavText>
                                </NavItem>
                                <NavItem eventKey="search">
                                    <NavIcon>
                                        <i className="fa fa-fw fa-home" style={{ fontSize: '1.75em' }} />
                                    </NavIcon>
                                    <NavText>
                                        Search Movie
                                    </NavText>
                                </NavItem>
                                <NavItem eventKey="log-in">
                                    <NavIcon>
                                        <i className="fa fa-fw fa-home" style={{ fontSize: '1.75em' }} />
                                    </NavIcon>
                                    <NavText>
                                        Log Out
                                    </NavText>
                                </NavItem>
                               
                            </SideNav.Nav>
                        </SideNav>


          
                        <Box className={css.box_for_showing_movies}>
                            {//this.state && this.state.length ? 
                          
                            this.state.movies.map(m => (
                              

                                <Card key={m.id} sx={{border:2, borderColor: 'white'}} >
                                    <Box >
                                    <CardMedia
                                    component="img"
                                    height="180"
                                    image={m.imagePath}
                                />
                                    </Box>
                                    <Box sx={{borderTop:2, borderColor: 'black'}} >{m.numeM}
                                    </Box>
                                    <Box  >{m.gen}</Box>
                                    
                                    <Button onClick={()=>this.handleClick(m.id)}>SHOW</Button>
                                </Card>

                            ))}
                        </Box>
                        <br />
                        <Box className={css.box_for_showing_movies}>
                            {//this.state && this.state.length ? 
                          
                            this.state.actors.map(a => (
                              

                                <Card key={a.id} sx={{border:2, borderColor: 'white'}} >
                                    <Box >
                                    <CardMedia
                                    component="img"
                                    height="180"
                                    image={a.imagePatha}
                                />
                                    </Box>
                                    <Box sx={{borderTop:2, borderColor: 'black'}} >{a.nume}
                                    </Box>
                                    <Box  >{a.varsta}</Box>
                                    
                                    <Button onClick={()=>this.handleClickActor(a.id)}>SHOW</Button>
                                </Card>

                            ))}
                        </Box>
                       
                    
                
                </div>
        );
               
    }

}

export default Search;