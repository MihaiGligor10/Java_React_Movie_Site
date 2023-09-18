import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import axiosInstance from "./axios";
import {Grid} from "@material-ui/core";
import history from './history';
import SideNav, { Toggle, Nav, NavItem, NavIcon, NavText } from '@trendmicro/react-sidenav';
import css from './CSS/Search.module.scss';

import {  Box, CardMedia, Card  } from '@mui/material';



class MyList extends React.Component {

    constructor() {
        super()
        this.state = {
            movies: [],
            ms: [],
        }
    };

    async componentDidMount(){
         axiosInstance.post("/recommendMovie",localStorage.getItem('USER_ID'))
        .then(
            res => {
                console.log("recomandat funtion");
                const v = res.data;
                localStorage.setItem('recomandat',v);
                console.log(localStorage.getItem('recomandat'));
                this.setState(
                    {
                        ms: v
                    }       
                );
                
            }
        )
        .catch(error => {
            console.log(error)
        })
        
        axiosInstance.post("/getMoviesByClient",localStorage.getItem('USER_ID'))
        .then(
            res => {
                const val = res.data;
                
                this.setState(
                    {
                        movies: val
                    }       
                );
                console.log(val);
                console.log(this.state);
            }
        )
        .catch(error => {
            console.log(error)
        })

    }


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

        handleClick (m) {
            localStorage.setItem('movieId', m )
            history.push("/movie");
            window.location.replace('http://localhost:3000/movie')
        }

        click (m) {
            let delml = {
                client: localStorage.getItem('USER_ID'),
                movie: m
            }
            axiosInstance.post("/deleteMovieList",delml)
            .then(
                res => {
                    const val = res.data;
                    
                    this.setState(
                        {
                            movies: val
                        }       
                    );
                    console.log(val);
                    console.log(this.state);
                }
            )
            .catch(error => {
                console.log(error)
            })
            window.location.reload();
        }

        generateTxt () {
          
            axiosInstance.post("/generateTXT", localStorage.getItem('USER_ID'))
            .then(
                res => {
                    const val = res.data;
                    console.log(val);
                    console.log(this.state);
                }
            )
            .catch(error => {
                console.log(error)
            })
            window.location.reload();
        }

render() {
        const { match, location, history } = this.props;
       // const ms = localStorage.getItem('recomandat');
       // console.log(localStorage.getItem('recomandat'));
        return(
            <div>

            <SideNav
             onSelect={this.handle}
             >
                <SideNav.Toggle />
                    <SideNav.Nav defaultSelected="mylist">
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
            {
            this.state.movies.map(m => (               
            
                <Card key={m.id} sx={{border:2, borderColor: 'white'}} >
                    <Box >
                        <CardMedia
                            component="img"
                            height="180"
                            image={m.imagePath}
                        />
                    </Box>
                    
                    <Box sx={{borderTop:2, borderColor: 'black'}} >{m.numeM}</Box>
                    <Box  >{m.gen}</Box>
                    <Button onClick={()=>this.handleClick(m.id)}>Show movie page</Button>
                    <Button onClick={()=>this.click(m.id)}>Delete from list</Button>
                </Card>

            ))}
           
        </Box>
        <br/>
        <br/>
        
        <Box className={css.box_for_showing_movies2}>
        
                      
            
                <Card key={this.state.ms.id} sx={{border:2, borderColor: 'white'}} >
                    <Box >
                        <CardMedia
                            component="img"
                            height="180"
                            image={this.state.ms.imagePath}
                        />
                    </Box>
                    
                    <Box sx={{borderTop:2, borderColor: 'black'}} >{this.state.ms.numeM}</Box>
                    <Box  >{this.state.ms.gen}</Box>
                    <Button onClick={()=>this.handleClick(this.state.ms.id)}>Show movie page</Button>
                    <Button onClick={()=>this.click(this.state.ms.id)}>Delete from list</Button>
                </Card>

           
        </Box>
        <br/>
        <Button className={css.txt_generate_btn} onClick={()=>this.generateTxt()}>Generate txt with the list</Button>
        <br/>

                           
                    
        </div>
            );
                   
    }

}

export default MyList;