import { AccountCircle } from '@mui/icons-material'
import { Alert, AppBar, Autocomplete, Box, Button, CardMedia, IconButton, Menu, MenuItem, Snackbar, TextField, Toolbar, Typography } from '@mui/material'
import ShoppingBagIcon from '@mui/icons-material/ShoppingBag';
import FavoriteIcon from '@mui/icons-material/Favorite';
import HomeIcon from '@mui/icons-material/Home';
import React from 'react'
import classes from './CSS/Movie.module.scss'
import { useState, useEffect } from 'react'
import axiosInstance from "./axios";
import history from './history';


class Actor extends React.Component {

    constructor(){
        super();
        this.state = {
         actor:[]
        }
    }
    
    handleHome = () => {
        console.log("handleHome");
        localStorage.removeItem('actorId');
        history.push("/home");
        window.location.reload();
    };

   
    
    handleInput = event => {
        const {value, name} = event.target;
        this.setState({
            [name]: value
        });

    };


   
    componentDidMount(){
        

        axiosInstance.post("/getActorById",localStorage.getItem('actorId'))
        .then(
            res => {
                const val = res.data;
                
                this.setState(
                    {
                       actor:val
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


 
    

    render() {
        const rev= localStorage.getItem('revs')
            return (

                <React.Fragment>
     
                <Box className={classes.left} >   
                

                    <Typography component="div" sx={{ flexGrow: 1 }}>
                        Filmento
                    </Typography><div className={classes.left}>
                            <Box>
                                <Typography className={classes.gen_value}>{this.state.actor.nume}</Typography>
                                <Button className={classes.back_btn} onClick={this.handleHome}> Back to Search</Button>
                                <br />
                                <Typography className={classes.name}><strong>{this.state.actor.varsta}</strong></Typography>
                                <br />
                                <Typography className={classes.description}>Description:</Typography>
                                <br />
                                <Typography className={classes.description_value}>{this.state.actor.istoric}</Typography>
                                <br />
                              
                                <br />
                                <br />      
                        
                            </Box>

                        </div><div className={classes.right}>
                            <Box className={classes.image_box}>
                                <CardMedia
                                    component="img"
                                    image={this.state.actor.imagePatha} />
                            </Box>
                        </div>

                </Box>
            
                </React.Fragment> 
            )
                       
    }
    
}
    
export default Actor;