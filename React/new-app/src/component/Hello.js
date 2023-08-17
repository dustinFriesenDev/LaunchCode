import styles from './Hello.module.css';

export default function Hello(){
    return (
        <div>
            <p className={styles.helloText}>Hello World!</p>
        </div>
    );
}