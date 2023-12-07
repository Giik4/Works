using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class scriptPortal : MonoBehaviour
{
    private void OnTriggerEnter2D(Collider2D col){
        SceneManager.LoadScene(3);
   }
}

