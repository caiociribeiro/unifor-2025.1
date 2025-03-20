export const movieRequest = async (title) => {
    const res = await fetch(`http://www.omdbapi.com/?apikey=&t=${title}`);
    const data = await res.json();

    if (data) return data;

    return null;
};