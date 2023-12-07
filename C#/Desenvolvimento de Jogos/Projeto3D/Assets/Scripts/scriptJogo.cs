using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;


public class scriptJogo : MonoBehaviour
{
    public void iniciar(){
        SceneManager.LoadScene(1);
        scriptUI.municao = 0;
        scriptUI.gema = 0;
        scriptUI.vida = 3;
    }

    public void sair(){
        Application.Quit();
    }

    public void menu(){
        SceneManager.LoadScene(0);
    }
}
