function getId(url) {
    const regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=|&v=)([^#&?]*).*/;
    const match = url.match(regExp);

    return (match && match[2].length === 11)
        ? match[2]
        : null;
}

function createCardTemplate(data){
    const template = document.querySelector('#card-template');
    const clone = document.importNode(template.content, true);

    const title = clone.querySelector('.title');
    title.textContent = data.name;

    const url = clone.querySelector('.url');
    const videoId = getId(data.url);
    url.innerHTML = '<iframe width="90%" height="315" src="//www.youtube.com/embed/'
        + videoId + '" frameborder="0" allowfullscreen></iframe>';
    document.querySelector('.main-wrapper').appendChild(clone);
}

function fillCards(videoData){
    console.log(videoData);
    for(let data of videoData){
        createCardTemplate(data)
    }
}

function init(){

    fetch('/videos/all', {
        method: 'GET',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
        .then(response =>fillCards(response));
}
init();
