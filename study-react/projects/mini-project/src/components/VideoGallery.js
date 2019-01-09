import React from 'react'

class VideoGallery extends React.Component {

    
    render() {
        return (
            <div className="video-gallery">
                <h4>video gallery</h4>
                <div className="preview-container">
                    <video src="https://pinoblob.blob.core.windows.net/videos/test1.mp4" controls style={{width:"40vw",height:"30vh"}}>
                    </video>
                </div>
            </div>
        )
    }
}

export default VideoGallery;