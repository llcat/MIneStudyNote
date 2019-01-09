import React from 'react'
import { Icon } from 'antd'
import './VCToolBar.css'
/*
    VideoCardToolBar Compnnent
    offer function: favorite, delete video, and show watched
*/

class VCToolBar extends React.Component {

    render(){
        const { videoInfo } = this.props
        return (
            <div className="vc-tool-bar">
                {videoInfo.watched?<Icon className="vc-watched" type="eye"/>:null}
                {videoInfo.favorite?
                    <Icon className="vc-favorite" type="heart" />
                    :<Icon className="vc-favorite" type="heart" style={{color:"red"}}/>
                }
                <Icon className="vc-delete" type="delete" />
            </div>
        )
    }
}

export default VCToolBar;