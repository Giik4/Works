using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
using UnityEngine.SceneManagement;
public class scriptUI : MonoBehaviour
{
    public TextMeshProUGUI gemaText;
    public TextMeshProUGUI municaoText;
    public TextMeshProUGUI vidaText;
    public static int gema = 0;
    public static int municao = 0;
    public static int vida = 3;
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        gemaText.text = ("Gema: " + (gema.ToString()) + "/264");
        
        municaoText.text = ("Municao: " + municao.ToString());

        vidaText.text = ("Vidas: " + vida.ToString());

        gameOver();
        finish();
    }

    void gameOver(){
        if(vida == 0)
        SceneManager.LoadScene(2);
    }

    void finish(){
        if(gema == 264)
        SceneManager.LoadScene(3);
    }

}
