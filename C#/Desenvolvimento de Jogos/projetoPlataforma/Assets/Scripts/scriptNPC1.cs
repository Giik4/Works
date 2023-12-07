using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class scriptNPC1 : MonoBehaviour
{
    public float velocidade = 5;
    private Rigidbody2D rbd;
    private AudioSource som;
    public GameObject trigger;
    public GameObject npc;
    public LayerMask mascara;
    private bool chao;
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
        rbd.velocity = new Vector2(velocidade,0);
        anim = GetComponent<Animator>();
        som = GetComponent<AudioSource>();
    }

    // Update is called once per frame
    void Update()
    {
        verificarChao();
        rotacionar();
        death();
    
    }

    private void verificarChao(){
        RaycastHit2D hit;
        hit = Physics2D.Raycast(trigger.transform.position, -trigger.transform.up, 0.1f, mascara);

        if(hit.collider != null){
            chao = true;
            }

        else{
            chao = false;
            }
       

    }

     private void rotacionar(){
        if (chao == false){
            velocidade = velocidade * -1;
            rbd.velocity= new Vector2(velocidade,0);
            transform.Rotate(new Vector2(0,180));
        }
     }

    private void death(){
        if(dano == true){
            rbd.velocity = new Vector2(0,0);
            anim.SetBool("dano", true);
            Vector2 posicao = new Vector2(npc.transform.position.x, 6.35f);
            this.transform.position = posicao;
            npc.GetComponent<CapsuleCollider2D>().enabled = false;

            Destroy(this.gameObject, 5f);
            
           
        }
    }


    
}
