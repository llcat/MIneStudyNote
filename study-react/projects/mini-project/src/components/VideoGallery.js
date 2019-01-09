import React from 'react'
import VideoCard from './VideoCard'
import VCToolBar from './VCToolBar'
import faker from 'faker'
import "./VideoGallery.css"

class VideoGallery extends React.Component {

    render() {
        let videoInfoList = [
            {
                id: "v-1",
                title: "ttye huhdus ttye huhdus ttye huhdus ttye huhdus",
                duration: "01:04:00",
                watched: false,
                favorite: true,
                watchedProgress: "3:50",
                watchedPercent: 30,
                previewUrl: faker.image.image(),
            },
            {
                id: "v-2",
                title: "master react",
                duration: "5:40",
                watched: true,
                favorite: false,
                watchedProgress: "00:50",
                watchedPercent: 10,
                previewUrl: faker.image.image(),
            },
            {
                id: "v-3",
                title: "who I am?",
                duration: "9:00",
                watched: false,
                favorite: true,
                watchedProgress: "0:00",
                watchedPercent: 0,
                previewUrl: faker.image.image(),
            },
            {
                id: "v-4",
                title: "ttye huhdus ttye huhdus ttye huhdus ttye huhdus",
                duration: "01:04:00",
                watched: true,
                favorite: false,
                watchedProgress: "3:50",
                watchedPercent: 30,
                previewUrl: faker.image.image(),
            },
            {
                id: "v-5",
                title: "master react",
                duration: "5:40",
                watched: true,
                favorite: false,
                watchedProgress: "00:50",
                watchedPercent: 10,
                previewUrl: faker.image.image(),
            },
          
        ]
        return (
            <div className="video-gallery">
                <div className="gallery-title">
                    <h4>video gallery</h4>
                </div>
                <div className="gallery-container">
                    {
                        videoInfoList.map((info)=>{
                            return (
                                <VideoCard key={info.id} videoInfo={info} >
                                    <VCToolBar key={`tool-${info.id}`} videoInfo={info} />
                                </VideoCard>
                            )
                        })
                    }
                </div>
            </div>
        )
    }

}

export default VideoGallery;