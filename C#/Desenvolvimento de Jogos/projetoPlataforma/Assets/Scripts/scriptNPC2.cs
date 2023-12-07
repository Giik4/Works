using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class scriptNPC2 : MonoBehaviour
{

     private Rigidbody2D rbd;
     private AudioSource som;
     public GameObject npc;
     public GameObject tiro;
     public Transform bocal;
     public float tempo=3f;
     private bool dano = false;
     private Animator anim;

    private void OnTriggerEnter2D(Collider2D col){
        dano = true;
        som.Play();
   }
    
    // Start is called before the first frame update
    void Start()
    {
        rbd = GetComponent<Rigidbody2D>();
        InvokeRepeating("atirar", 0, tempo);
        anim = GetComponent<Animator>();
        som = GetComponent<AudioSource>();
    }

    // Update is called once per frame
    void Update()
    {
        death();
    }

    private void atirar(){
        Instantiate(tiro, bocal.position, Quaternion.identity);
        anim.SetTrigger("atirar");
    }

    private void death(){
        if(dano == true){
            CancelInvoke();
            anim.SetBool("dano", true);
            Vector2 posicao = new Vector2(npc.transform.position.x, 1.45f);
            this.transform.position = posicao;
            npc.GetComponent<CapsuleCollider2D>().enabled = false;

            Destroy(this.gameObject, 5f);
            
           
        }
    }
   
}
