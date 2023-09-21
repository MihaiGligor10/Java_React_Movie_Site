import { AccountCircle, Height } from '@mui/icons-material'
import { Alert, AppBar, Autocomplete, Box, Button, CardMedia, IconButton, Menu, MenuItem, Snackbar, TextField, Toolbar, Typography } from '@mui/material'
import ShoppingBagIcon from '@mui/icons-material/ShoppingBag';
import FavoriteIcon from '@mui/icons-material/Favorite';
import HomeIcon from '@mui/icons-material/Home';
import React from 'react'
import classes from './CSS/Movie.module.scss'
import { useState, useEffect } from 'react'
import axiosInstance from "./axios";
import history from './history';


class Movie extends React.Component {

    constructor(){
        super();
        this.state = {
         movie:[]
        }
    }
 
    
    handleHome = () => {
        console.log("handleHome");
        localStorage.removeItem('movieId');
        history.push("/search");
        window.location.reload();
    };


    likeMovie = () => {
        console.log("like movie");
        let m = {
            client: localStorage.getItem('USER_ID'),
            movie: localStorage.getItem('movieId'),
            liker: true
        }
        console.log(m);
        axiosInstance.post("/likeMovie",m)
        .then(
            res => {
                const val = res.data;
                console.log(val);
            }
        )
        .catch(error => {
            console.log(error)
        })
        
    };


    dislikeMovie = () => {
        console.log("dislike movie");
        let m = {
            client: localStorage.getItem('USER_ID'),
            movie: localStorage.getItem('movieId'),
            liker: false
        }
        console.log(m);
        axiosInstance.post("/likeMovie",m)
        .then(
            res => {
                const val = res.data;
               console.log(val);

            }
        )
        .catch(error => {
            console.log(error)
        })
        
    };



    addMovieList = () => {
        console.log("addMovieList");
        let m = {
            client: localStorage.getItem('USER_ID'),
            movie: localStorage.getItem('movieId')
        }
        console.log(m);
        axiosInstance.post("/addML",m)
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
        
    };

    
    handleInput = event => {
        const {value, name} = event.target;
        this.setState({
            [name]: value
        });

    };

    addReview = () => {
        console.log("add review");
        let m = {
            client: localStorage.getItem('USER_ID'),
            movie: localStorage.getItem('movieId'),
            review:this.state.review
        }
        console.log(m);
        axiosInstance.post("/reviewMovie",m)
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
        window.location.reload()
    };

   
    componentDidMount(){
        console.log(localStorage.getItem('movieId'));


        axiosInstance.post("/getByIdMovie",localStorage.getItem('movieId'))
        .then(
            res => {
                const val = res.data;
                
                this.setState(
                    {
                       movie:val
                    }       
                );
                console.log(val);
                console.log(this.state);
                console.log(this.state.movie.imagePath);
            }
        )
        .catch(error => {
            console.log(error)
        })


        console.log(localStorage.getItem('movieId'));
        axiosInstance.post("/getAllReviewsForMovie",localStorage.getItem('movieId'))
        .then(
            res => {
                console.log("reviews");
                
                const val = res.data;
                console.log(val);
                localStorage.setItem('revs',val);
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
     
                <Box className={classes.right} >   
                

                    <Typography component="div" sx={{ flexGrow: 1 }}>
                        Filmento
                    </Typography><div className={classes.right}>
                            <Box>
                                <Typography className={classes.gen_value}>{this.state.movie.gen}</Typography>
                                <Button className={classes.back_btn} onClick={this.handleHome}> Back to Search</Button>
                                <br />
                                <Typography className={classes.name}><strong>{this.state.movie.numeM}</strong></Typography>
                                <br />
                                <Typography className={classes.description}>Description:</Typography>
                                <br />
                                <Typography className={classes.description_value}>{this.state.movie.descriere}</Typography>
                                <br />

                                <Button onClick={this.likeMovie} className={classes.like_movie}>Like Movie</Button>
                                <Button onClick={this.dislikeMovie} className={classes.like_movie}>Dislike Movie</Button>
                                <Button onClick={this.addMovieList} className={classes.add_to_list}>Add to list</Button>
                                <br />
                               <br />
                               
                               
                               <Button onClick={this.addReview}>Post Review</Button>
                               <br />
                               <TextField className={classes.review_movie}
                                        variant="filled"
                                        margin="dense"
                                        name="review"
                                        label="Write a review"
                                        id="movieimagepath"
                                        multiline
                                        onChange={this.handleInput}
                                       
                                />
                                
                                   <textarea className={classes.reviews} readOnly value={rev}>
                                       
                                   </textarea>
                               
                               <br />
                                <br />      
                              
                                
                                

                            </Box>
                        </div><div className={classes.left}>
                            <Box className={classes.image_box}>
                                <CardMedia
                                    component="img"
                                    image={this.state.movie.imagePath} 
                                    
                                />
                            </Box>
                        </div>

                </Box>
            
                </React.Fragment>
            )
                       
    }
    
}
    
export default Movie;

