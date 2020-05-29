export function fetchData(url, data,type,callback) {

    fetch(url, {
        method: type,
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
        .then(response =>callback(response));
}
