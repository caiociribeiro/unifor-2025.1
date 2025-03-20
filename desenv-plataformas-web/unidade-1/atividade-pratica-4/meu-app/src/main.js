import './style.css'
import { movieRequest } from './api-request'

document.querySelector('#app').innerHTML = `
  <div>
    <h1>What's the plot of the movie?</h1>
    <div id="movie_info"></div>
    <input type="text" id="input_movie" placeholder="Type a movie" />
    <div class="card">
      <button id="search" type="button">Search</button>
    </div>
  </div>
`

document.addEventListener("click", async e => {
  if (e.target.id === "search") {
    const input = document.querySelector('#input_movie').value;
    const data = await movieRequest(input);
    
    console.log(data);

    document.querySelector('#movie_info').innerHTML = `
      <h2>${data.Title} (${data.Year})</h2>
      <p>${data.Plot}</p>
    `;
  }
});