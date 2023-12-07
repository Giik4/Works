using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class scriptVida : MonoBehaviour
{
    public int contVida = 3;
    public Image[] vida;
    scriptPC pc;
    public float alturaMorte = -25;
    


    // Start is called before the first frame update
    void Start()
    {
        pc = GetComponent<scriptPC>();
    }

    // Update is called once per frame
    void Update()
    {
        verificarVida();
        morte();
        queda();

    }

    private void verificarVida(){
        for (int i = 0; i < vida.Length; i++){
            if(i < contVida){
                vida[i].enabled = true;
            }
            else{
                vida[i].enabled = false;
            }
        }
    }

    private void morte(){
        if(contVida <= 0 ){
            GetComponent<scriptPC>().enabled = false;
            pc.rbd.velocity = new Vector2(0,0);
            pc.anim.SetBool("morto", true);
            pc.GetComponent<CapsuleCollider2D>().enabled = false;
            pc.rbd.isKinematic = true;
            Invoke("gameOver",5);
            
        }
    }

    private void queda(){
        if(pc.transform.position.y < alturaMorte )
            contVida = 0;
    }

    private void gameOver(){
        SceneManager.LoadScene(2);
    }
}
