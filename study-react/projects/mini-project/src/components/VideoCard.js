import React from 'react'
import { Icon, Progress, Tooltip } from 'antd'
import './VideoCard.css'

// video preview card
/*
  this component consists of three parts
  1. a img preview
  2. a hover info panel
  3. a video operate container

  features:
  1. show a video's preview img
  2. when mouse hover, the info panel will show video's title, duration and watched progress
  3. offer an operate container, so you can define your costom feature:
     somethings like favorite, watched, delete and so on.
*/

class VideoCard extends React.Component {

    render(){
        const { videoInfo } = this.props
        return (
            <div className="video-card">
                <div className="preview-container">
                    <img className="video-preview" src={videoInfo.previewUrl} alt="" />
                    <div className="video-info-panel">
                        <div className="video-info">
                            <h4 className="video-info-title">{videoInfo.title}</h4>
                            <span className="video-info-duration">{videoInfo.duration}</span>
                        </div>
                        <div className="start-play">
                            <Icon type="play-circle" style={{fontSize: "3vw", color:"white"}}/>
                        </div>
                        <div className="progress-container">
                            <Tooltip title={`${videoInfo.watchedProgress}/${videoInfo.duration}`}>
                                <Progress 
                                percent={videoInfo.watchedPercent} 
                                strokeWidth={3}
                                showInfo={false} 
                                />
                            </Tooltip>
                        </div>
                    </div>
                </div>
                <div className="video-operate-container">
                    {this.props.children}
                </div>
            </div>
        )
    }

}

export default VideoCard;