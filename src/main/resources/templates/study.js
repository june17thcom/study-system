import React, { useEffect, useState } from 'react';
import axios from 'axios';

function StudyList() {
    const [studies, setStudies] = useState([]);
    const [message, setMessage] = useState('');

    useEffect(() => {
        axios.get('/study?page=1&size=10')
            .then(res => setStudies(res.data))
            .catch(err => console.error(err));
    }, []);

    const applyToStudy = (id) => {
        axios.post('/application/apply', null, { params: { studyId: id } })
            .then(() => setMessage('신청 완료'))
            .catch(() => setMessage('이미 신청했거나 정원이 초과되었습니다.'));
    };

    return (
        <div>
            <h1>스터디 목록</h1>
            {message && <p>{message}</p>}
            <ul>
                {studies.map(study => (
                    <li key={study.id}>
                        <strong>{study.title}</strong> (모집인원: {study.maxParticipants})<br />
                        <button onClick={() => applyToStudy(study.id)}>신청하기</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default StudyList;
